package com.bichuang.service.account;

import java.util.Map;

import org.json.JSONObject;

import com.bichuang.repository.model.account.BalanceAccountC;
import com.bichuang.vo.account.AccountCChangeVo;
import com.bichuang.vo.account.AccountReqVO;
import com.bichuang.vo.account.ApplyBindBankCardReqVO;
import com.bichuang.vo.account.BindBankCardReqVO;
import com.bichuang.vo.account.DepositApplyReqVO;
import com.bichuang.vo.account.DepositNotifyReqVO;
import com.bichuang.vo.account.SendSmsReqVO;
import com.bichuang.vo.account.WithdrawApplyReqVO;


public interface BalanceAccountCService extends BaseService<BalanceAccountC, Integer> {

	public int updateAccount(AccountReqVO accountReqVO);

	public int updateAmount(DepositNotifyReqVO depositNotifyReqVO);

	public int updateByCusId(BalanceAccountC balanceAccountC);

	public int updateOrderStatus(DepositNotifyReqVO depositNotifyReqVO);

	public Map<String, Object> requestCreateMember(AccountReqVO accountReqVO) throws Exception;

	public BalanceAccountC getAccount(AccountReqVO accountReqVO);

	public JSONObject requestSendSms(SendSmsReqVO sendSmsReqVO) throws Exception;

	public Map<String, Object> requestAuthRealname(AccountReqVO accountReqVO) throws Exception;

	public Map<String, Object> requestSignContract(AccountReqVO accountReqVO) throws Exception;

	public JSONObject requestSignContractNotify(AccountReqVO accountReqVO) throws Exception;

	public Map<String, Object> requestBindPhone(SendSmsReqVO sendSmsReqVO) throws Exception;

	public Map<String, Object> requestApplyBindBankCard(ApplyBindBankCardReqVO applyBindBankCardReqVO) throws Exception;

	public Map<String, Object> requestgetBankCardBin(ApplyBindBankCardReqVO applyBindBankCardReqVO) throws Exception;

	public Map<String, Object> requestBindBankCard(BindBankCardReqVO bindBankCardReqVO) throws Exception;

	public Map<String, Object> requestSetPayPwd(AccountReqVO accountReqVO) throws Exception;

	public Map<String, Object> requestUpdatePayPwd(AccountReqVO accountReqVO) throws Exception;

	public Map<String, Object> requestDepositApply(DepositApplyReqVO depositApplyReqVO) throws Exception;

	public Map<String, Object> requestWithdrawApply(WithdrawApplyReqVO withdrawApplyReqVO) throws Exception;

	public Map<String, Object> WithdrawConfirmPay(WithdrawApplyReqVO withdrawApplyReqVO) throws Exception;

	public Map<String, Object> requestQueryBalance(AccountReqVO accountReqVO) throws Exception;

	public Map<String, Object> queryInExpDetail(AccountReqVO AccountReqVO) throws Exception;

	public BalanceAccountC getBalanceAccountC(String custId);

	public boolean updateAccountAmount(AccountCChangeVo vo, BalanceAccountC balanceAccountC);

}
