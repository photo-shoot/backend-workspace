package photoshoot.backendworkspace.security;

import lombok.Getter;

@Getter
public class AttemptLogin {
    String email;
    String type;
    public AttemptLogin(String email, String type){
        this.email = email;
        this.type = type;
    }
}
