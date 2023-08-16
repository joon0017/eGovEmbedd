package egovframework.example.petition.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.petition.service.PetService;
import egovframework.example.petition.service.PetVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("petService")
public class PetServiceImpl extends EgovAbstractServiceImpl implements PetService {

	@Resource(name="primaryTypeSequenceIds")
	EgovIdGnrService egovIdGnrService;
	
	@Resource(name="petDAO")
	private PetDAO petDAO;

	public BigDecimal insertPet(PetVO petVO) throws Exception {
		BigDecimal generatedPetNo = egovIdGnrService.getNextBigDecimalId();
		egovLogger.debug("PetServiceImpl.insertPet - generated petNo : " + generatedPetNo);

		petVO.setArticle_id(generatedPetNo);
 
		petDAO.insertPet(petVO);

		return generatedPetNo;
	}

	public void updatePet(PetVO petVO) throws Exception {
		petDAO.updatePet(petVO);
	}

	public void deletePet(PetVO petVO) throws Exception {
		petDAO.deletePet(petVO);
	}

	public PetVO selectPet(PetVO petVO) throws Exception {
		PetVO resultVO;
		resultVO = petDAO.selectPet(petVO);
		
		if (resultVO == null) {
			throw processException("info.nodata.msg");
		}
		
		return petVO;
	}

	public List<PetVO> selectPetList(PetVO searchVO) throws Exception {
		return petDAO.selectPetList(searchVO);
		
	}
}
