package egovframework.example.embDAO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("embDAO")
public class EmbDAO extends EgovAbstractDAO{
	
	//emb 데이타 입력
	public String insertEmb(EmbVO vo) throws Exception{
		return (String) insert("embDAO.insertEmb",vo);
	}

	//emb 데이타 읽어내기
	public EmbVO selectEmb(EmbVO vo) throws Exception{
		return (EmbVO) select("embDAO.selectEmb",vo);
	}	
}
