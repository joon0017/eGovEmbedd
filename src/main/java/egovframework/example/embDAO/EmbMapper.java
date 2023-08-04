package egovframework.example.embDAO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.example.embDAO.EmbVO;

@Mapper("embMapper")
public interface EmbMapper {
	
	void insertEmb(EmbVO vo) throws Exception;
	EmbVO selectEmb(EmbVO vo) throws Exception;

}
