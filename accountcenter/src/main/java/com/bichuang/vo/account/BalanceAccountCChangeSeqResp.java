package com.bichuang.vo.account;

import java.math.BigDecimal;

public class BalanceAccountCChangeSeqResp {
	private BigDecimal totalPay;

	private BigDecimal cashAmountPay;

	private BigDecimal cashAmount;

	private BigDecimal totalDeposit;

	private BigDecimal totalShiftTo;

	private BigDecimal lastSurplus;

	private BigDecimal freezeCashAmout;

	public BigDecimal getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}

	public BigDecimal getCashAmountPay() {
		return cashAmountPay;
	}

	public void setCashAmountPay(BigDecimal cashAmountPay) {
		this.cashAmountPay = cashAmountPay;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(BigDecimal totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public BigDecimal getTotalShiftTo() {
		return totalShiftTo;
	}

	public void setTotalShiftTo(BigDecimal totalShiftTo) {
		this.totalShiftTo = totalShiftTo;
	}

	public BigDecimal getLastSurplus() {
		return lastSurplus;
	}

	public void setLastSurplus(BigDecimal lastSurplus) {
		this.lastSurplus = lastSurplus;
	}

	public BigDecimal getFreezeCashAmout() {
		return freezeCashAmout;
	}

	public void setFreezeCashAmout(BigDecimal freezeCashAmout) {
		this.freezeCashAmout = freezeCashAmout;
	}

}
