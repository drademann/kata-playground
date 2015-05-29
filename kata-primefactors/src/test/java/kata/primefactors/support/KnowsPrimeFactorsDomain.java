package kata.primefactors.support;

import java.util.List;

public class KnowsPrimeFactorsDomain {

	private int inputNumber;
	private List<Integer> primeFactors;

	//<editor-fold desc="getter/setter">
	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}

	public List<Integer> getPrimeFactors() {
		return primeFactors;
	}

	public void setPrimeFactors(List<Integer> primeFactors) {
		this.primeFactors = primeFactors;
	}
	//</editor-fold>
}
