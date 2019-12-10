package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.AccountListDomain;
import kr.co.prj.domain.CardListDomain;
import kr.co.prj.domain.PassHintDomain;
import kr.co.prj.vo.PayForBankVO;
import kr.co.prj.vo.PayForCardVO;

public class PaymentDAO {
	private static PaymentDAO pDao;
	public static SqlSessionFactory ssf;

private PaymentDAO() {
}

	public static PaymentDAO getInstance() {
		if (pDao == null) {
			pDao = new PaymentDAO();
		} // end if
		return pDao;
	}// getInstance

	public SqlSessionFactory getSessionFactory() throws IOException {// �̱��� //ssf�� ���� ��쿡�� ��������� �ִٸ� ��������� �ʴ´�.
		if (ssf == null) {

			Reader reader = null;
			try {
				// 1.������ xml�� ��Ʈ������ ����
				reader = Resources.getResourceAsReader("kr/co/prj/dao/mybatis-config.xml");
				// 2.SqlSessionFactoryBuilder ����
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				// 3.SqlSessionFactory ���
				ssf = ssfb.build(reader);

			} finally {
				if (reader != null) {
					reader.close();
				} // end if
			} // end finally

		} // end if
		return ssf;
	}// getSessionFactory
	
	
	public List<AccountListDomain> AccountList(){
		//���������� ��Ʈ�� ���Դµ� Integer�� �޴°� �����Ѱ���~����
		List<AccountListDomain> acList=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//�ԷµǴ� �� ���� ��� ���ڵ带 ��ȸ
			acList=ss.selectList("accountList");
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return acList;	
	}//singleColumnMultiRow
	
	public List<CardListDomain> cardList(String id){
		//���������� ��Ʈ�� ���Դµ� Integer�� �޴°� �����Ѱ���~����
		List<CardListDomain> caList=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//�ԷµǴ� �� ���� ��� ���ڵ带 ��ȸ
			caList=ss.selectList("selectCard", id);
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return caList;	
	}//singleColumnMultiRow
	
	
	public int payForCard( PayForCardVO pcVO ) throws SQLException {
		int cnt=0;
		
		try {
			//MyBatix Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//���� �����ϰ�
			cnt=ss.update("payForCard", pcVO);
			//�ٸ� mapper�� �Ȱ��� �̸� ���� ������. �׷��� namespace�� id�� ���ս�Ű�� ���̵� ��������!
			//����� ���� transaction �Ϸ� 
			if(cnt==1) {
				ss.commit();
			}//end if
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}//updateCpEmp
	
	public int payForBank1( PayForBankVO pbVO ) throws SQLException {
		int cnt=0;
		
		try {
			//MyBatix Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//���� �����ϰ�
			cnt=ss.update("payForBank1", pbVO);
			//�ٸ� mapper�� �Ȱ��� �̸� ���� ������. �׷��� namespace�� id�� ���ս�Ű�� ���̵� ��������!
			//����� ���� transaction �Ϸ� 
			if(cnt==1) {
				ss.commit();
			}//end if
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}//updateCpEmp
	
	
	
	public int payForBank2(PayForBankVO pbVO) throws SQLException{
		int cnt=0;
		try {
			//4. MyBatis Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ��´�.
			cnt=ss.insert("payForBank2", pbVO); //���⼭ ���������� �ؿ��� ��Ÿ�� �����ϱ� transactionó�� �ؿ� ���൵ ��
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
