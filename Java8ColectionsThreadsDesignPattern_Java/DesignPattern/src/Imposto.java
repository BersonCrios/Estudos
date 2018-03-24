public abstract class Imposto {
	
	protected Imposto outroImposto;
	
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;

	}
	
	public Imposto() {

	}
	
	public abstract double calcula(Orcamento o);
	
	protected double calculoDoOutroImposto(Orcamento o) {
		if (outroImposto == null) {
			return 0;
		}
		return outroImposto.calcula(o);
	}
}
