package egovframework.example.petition.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.petition.service.PetVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("petDAO")
public class PetDAO extends EgovAbstractDAO {
	
	
	public void insertPet(PetVO vo) {
		insert("insertPet",vo);
	}

	public int updatePet(PetVO vo) {
		return update("updatePet",vo);
	}

	public int deletePet(PetVO vo) {
		return delete("deletePet",vo);
	}

	public PetVO selectPet(PetVO vo) {
		return (PetVO) select("selectPet",vo);
	}

	@SuppressWarnings("unchecked")
	public List<PetVO> selectPetList(PetVO vo) {
		return (List<PetVO>) list("selectPetList",vo);
	}	
}
