package photoshoot.backendworkspace.oauth;

import lombok.Builder;
import lombok.Getter;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Member;

import java.util.Map;

@Getter
// OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스다.
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String email; // 회원 이메일만

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String email){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
    }

    public static OAuthAttributes of(String socialName, String userNameAttributeName, Map<String, Object> attributes){
        if("naver".equals(socialName)) return ofNaver("id", attributes);
        // if("kakao".equals(socialName)) return ofKaKao("id", attributes)
        else return null;
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");
        return OAuthAttributes.builder()
                .email(response.get("email").toString())
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // 네이버 계정에서 이메일만 가져오고, 나머지는 사용자가 직접 치기
    public Member toMemberEntity(){
        return Member.builder()
                .email(email)
                .build();
    }

    // 네이버 계정에서 이메일만 가져오고, 나머지는 사용자가 직접 치기
    public Admin toEntityEntity(){
        return Admin.builder()
                .email(email)
                .build();
    }

}
