package photoshoot.backendworkspace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.dto.photographer.PhotographerDTO;
import photoshoot.backendworkspace.dto.photographer.PhotographerListResponseDTO;
import photoshoot.backendworkspace.entity.Photographer;
import photoshoot.backendworkspace.repository.PhotographerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PhotographerService {

    private final PhotographerRepository photographerRepository;

    public PhotographerListResponseDTO listPhotographer(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Photographer> photographerPage = photographerRepository.findAll(pageable);
        List<Photographer> photographerList = photographerPage.getContent();
        List<PhotographerDTO> photographerDTOList = photographerList.stream().map(photographer -> Photographer.toDTO(photographer)).collect(Collectors.toList());
        PhotographerListResponseDTO photographerListResponse = new PhotographerListResponseDTO();
        photographerListResponse.setPhotographerDTOList(photographerDTOList);
        photographerListResponse.setPageNo(pageNo);
        photographerListResponse.setPageSize(pageSize);
        photographerListResponse.setTotalElements(photographerPage.getTotalElements());
        photographerListResponse.setTotalPages(photographerPage.getTotalPages());
        return photographerListResponse;
    }

    public List<Photographer> all(){
        return photographerRepository.findAll();
    }
}
