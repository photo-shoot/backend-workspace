package photoshoot.backendworkspace.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.dto.test.TestAdminDTO;
import photoshoot.backendworkspace.dto.test.TestMemberDTO;
import photoshoot.backendworkspace.dto.test.TestPhotographerDTO;
import photoshoot.backendworkspace.dto.test.TestStudioDTO;
import photoshoot.backendworkspace.entity.Member;
import photoshoot.backendworkspace.repository.AdminRepository;
import photoshoot.backendworkspace.repository.MemberRepository;
import photoshoot.backendworkspace.repository.PhotographerRepository;
import photoshoot.backendworkspace.repository.StudioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TestService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PhotographerRepository photographerRepository;
    @Autowired
    StudioRepository studioRepository;

    public List<TestMemberDTO> memberAll(){
        List<TestMemberDTO> res = memberRepository.findAll().stream().map(member -> TestMemberDTO.toDTO(member)).collect(Collectors.toList());
        return res;
    }

    public List<TestAdminDTO> adminAll(){
        List<TestAdminDTO> res = adminRepository.findAll().stream().map(admin -> TestAdminDTO.toDTO(admin)).collect(Collectors.toList());
        return res;
    }

    public List<TestStudioDTO> studioAll(){
        List<TestStudioDTO> res = studioRepository.findAll().stream().map(studio -> TestStudioDTO.toDTO(studio)).collect(Collectors.toList());
        return res;
    }

    public List<TestPhotographerDTO> photographerAll(){
        List<TestPhotographerDTO> res = photographerRepository.findAll().stream().map(photographer -> TestPhotographerDTO.toDTO(photographer)).collect(Collectors.toList());
        return res;
    }
}
