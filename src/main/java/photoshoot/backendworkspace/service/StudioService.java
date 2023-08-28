package photoshoot.backendworkspace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import photoshoot.backendworkspace.dto.photographer.PhotographerDTO;
import photoshoot.backendworkspace.dto.photographer.PhotographerListResponseDTO;
import photoshoot.backendworkspace.dto.studio.StudioDTO;
import photoshoot.backendworkspace.dto.studio.StudioListResponseDTO;
import photoshoot.backendworkspace.entity.Photographer;
import photoshoot.backendworkspace.entity.Studio;
import photoshoot.backendworkspace.repository.StudioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public List<Studio> all(){
        return studioRepository.findAll();
    }

    public StudioListResponseDTO listStudio(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Studio> studioPage = studioRepository.findAll(pageable);
        List<Studio> studioList = studioPage.getContent();
        List<StudioDTO> photographerDTOList = studioList.stream().map(studio -> Studio.toDTO(studio)).collect(Collectors.toList());
        StudioListResponseDTO studioListResponseDTO = new StudioListResponseDTO();
        studioListResponseDTO.setPhotographerDTOList(photographerDTOList);
        studioListResponseDTO.setPageNo(pageNo);
        studioListResponseDTO.setPageSize(pageSize);
        studioListResponseDTO.setTotalElements(studioPage.getTotalElements());
        studioListResponseDTO.setTotalPages(studioPage.getTotalPages());
        return studioListResponseDTO;
    }

}
