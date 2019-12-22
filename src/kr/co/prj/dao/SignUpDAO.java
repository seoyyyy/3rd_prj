package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.CardTypeDomain;
import kr.co.prj.domain.PassHintDomain;
import kr.co.prj.vo.CardInfoVO;
import kr.co.prj.vo.SignUpVO;

public class SignUpDAO {
	private static SignUpDAO suDao;
	public static SqlSessionFactory ssf;
	
	private SignUpDAO() {
	}

	public static SignUpDAO getInstance() {
		if(suDao==null) {
			suDao=new SignUpDAO();
		}//end if
		return suDao;
	}//getInstance
	
	public SqlSessionFactory getSessionFactory()throws IOException {//�̱��� //ssf�� ���� ��쿡�� ��������� �ִٸ� ��������� �ʴ´�.
		if(ssf==null) {
			
			Reader reader = null;
			try {
				//1.������ xml�� ��Ʈ������ ����
					reader = Resources.getResourceAsReader("kr/co/prj/dao/mybatis-config.xml");
				//2.SqlSessionFactoryBuilder ����
					SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3.SqlSessionFactory ���
					ssf= ssfb.build(reader);
				 
			}finally {
				if(reader!=null) {reader.close();}//end if
			}//end finally
			
		}//end if
		return ssf;
	}//getSessionFactory
	
	public List<PassHintDomain> passHintList(){
		//���������� ��Ʈ�� ���Դµ� Integer�� �޴°� �����Ѱ���~����
		List<PassHintDomain> phList=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//�ԷµǴ� �� ���� ��� ���ڵ带 ��ȸ
			phList=ss.selectList("passHint");
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return phList;	
	}//singleColumnMultiRow
	
	public List<CardTypeDomain> cardTypeList(){
		List<CardTypeDomain> ctList = null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			ctList = ss.selectList("cardType");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return ctList;
		
	}
	
	public int insertSignUp(SignUpVO suVO) throws SQLException{
		int cnt=0;
		try {
			//4. MyBatis Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ��´�.
			cnt=ss.insert("SignUp", suVO); //���⼭ ���������� �ؿ��� ��Ÿ�� �����ϱ� transactionó�� �ؿ� ���൵ ��
			//transaction ó��
			System.out.println("Ŀ�� ��");
			ss.commit();
			System.out.println("Ŀ�� �Ϸ�");
			
			//Handler�� ���Ϸ� �ߴٸ� �����Ѵ�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		
		return cnt;
	}//insertCpEmp
	
	public int insertCardInfo(CardInfoVO ciVO) throws SQLException{
		int cnt=0;
		try {
			//4. MyBatis Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ��´�.
			cnt=ss.insert("inputCardInfo", ciVO); //���⼭ ���������� �ؿ��� ��Ÿ�� �����ϱ� transactionó�� �ؿ� ���൵ ��
			//transaction ó��
			ss.commit();
			
			//Handler�� ���Ϸ� �ߴٸ� �����Ѵ�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		
		return cnt;
	}//insertCpEmp
	

}
