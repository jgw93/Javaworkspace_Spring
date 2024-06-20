package org.zerock.b01.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User implements OAuth2User {
    //멤버 변수 설정
    private String mid;
    private String mpw;
    private String email;
    private String checkmpw;
    private String name;
    private String address;
    private boolean del;
    private boolean social;
    private Map<String, Object> props; //소셜 로그인 정보
    //생성자
    public MemberSecurityDTO(String username, String password, String email,
                             String checkmpw , String name ,String address,
                             boolean del, boolean social,
                             Collection<? extends GrantedAuthority> authorities) {
        //부모 클래스를 부르는 super
        super(username, password, authorities);

        this.mid = username;
        this.mpw = password;
        this.email = email;
        this.checkmpw = checkmpw;
        this.name = name;
        this.address = address;
        this.del = del;
        this.social = social;
    }

    @Override
     public Map<String, Object> getAttributes() {
        return this.getProps();
    }
    @Override
    public String getName() {
        return this.mid;
    }
}
