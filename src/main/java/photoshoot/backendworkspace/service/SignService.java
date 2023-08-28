package photoshoot.backendworkspace.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.dto.sign.SignupRequestDTO;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Member;
import photoshoot.backendworkspace.exception.CustomException;
import photoshoot.backendworkspace.repository.AdminRepository;
import photoshoot.backendworkspace.repository.MemberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;

    public ResponseEntity<?> signup(SignupRequestDTO dto){
        checkDuplicatedEmail(dto.getEmail());
        checkDuplicatedNickname(dto.getNickname());
        return saveUser(dto);
    }

    private void checkDuplicatedEmail(String email){
        if(adminRepository.existsByEmail(email) || memberRepository.existsByEmail(email))
            throw new CustomException("이미 이메일이 존재합니다", HttpStatus.CONFLICT);
    }

    private void checkDuplicatedNickname(String nickname){
        if(adminRepository.existsByNickname(nickname) || memberRepository.existsByNickname(nickname))
            throw new CustomException("이미 닉네임이 존재합니다", HttpStatus.CONFLICT);
    }

    private ResponseEntity<?> saveUser(SignupRequestDTO dto){
        System.out.println(dto.getType() + "이 dto의 타입이다");
        if(dto.getType().equals("ADMIN")) return ResponseEntity.ok().body(saveAdmin(dto).getNickname() + "님 ADMIN 회원가입 완료되었습니다!");
        else return ResponseEntity.ok().body(saveMember(dto).getNickname() + "님 MEMBER 회원가입 완료되었습니다!");
    }

    @Transactional
    private Member saveMember(SignupRequestDTO dto){
        return memberRepository.save(SignupRequestDTO.toMemberEntity(dto));
    }

    @Transactional
    private Admin saveAdmin(SignupRequestDTO dto){
        return adminRepository.save(SignupRequestDTO.toAdminEntity(dto));
    }
}
