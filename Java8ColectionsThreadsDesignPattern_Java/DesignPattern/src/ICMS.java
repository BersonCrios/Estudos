public class ICMS extends Imposto{
	
	public ICMS() {

	}

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}
	
	
	@Override
	public double calcula(Orcamento o){
		return o.getValor() * 0.1 + calculoDoOutroImposto(o);
	}
	
	
}
