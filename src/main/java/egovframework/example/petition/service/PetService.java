package egovframework.example.petition.service;

import java.math.BigDecimal;
import java.util.List;

public interface PetService {
	public double insertPet(PetVO petVO) throws Exception;
	public void updatePet(PetVO petVO) throws Exception;
	public void deletePet(PetVO petVO) throws Exception;
	public PetVO selectPet(PetVO petVO) throws Exception;
	public List<PetVO> selectPetList(PetVO petVO) throws Exception;
}
