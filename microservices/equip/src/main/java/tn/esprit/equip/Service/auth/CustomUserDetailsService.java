package tn.esprit.equip.Service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.equip.Entity.Agent;
import tn.esprit.equip.Entity.User;
import tn.esprit.equip.Repository.AgentRepository;
import tn.esprit.equip.Repository.User2Repository;
import tn.esprit.equip.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AgentRepository agentRepository;
    private final User2Repository userRepository2;
    public CustomUserDetailsService(UserRepository userRepository, AgentRepository agent, AgentRepository agentRepository, User2Repository userRepository2) {
        this.userRepository = userRepository;
        this.agentRepository = agentRepository;

        this.userRepository2 = userRepository2;
    }

    @Override
    public UserDetails loadUserByUsername(String RegistrationNumber) throws UsernameNotFoundException {
        Agent agent = agentRepository.findByUser_RegistrationNumber(RegistrationNumber);
        if (agent == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(agent.getUser().getRegistrationNumber())
                .password(agent.getPassword())
                .roles(agent.getRole())
                .build();
    }

    public String getUserIdByUsername(String email) {
        User user = userRepository2.findByEmail(email);  // Récupérer l'utilisateur depuis la base de données
        if (user != null) {
            return user.getRegistrationNumber();  // Retourner le numéro d'enregistrement de l'utilisateur
        }
        return null;
    }
    public String getUserusername(String email) {
        User user = userRepository2.findByEmail(email);  // Récupérer l'utilisateur depuis la base de données
        if (user != null) {
            return user.getUsername();  // Retourner l'ID de l'utilisateur
        }
        return null;
    }
    public String getUserRoleByUsername(String username) {
        User user = userRepository2.findByEmail(username);  // Récupérer l'utilisateur depuis la base de données
        if (user != null) {
            return user.getRole();  // Retourner l'ID de l'utilisateur
        }
        return null;
    }

}
