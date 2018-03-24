public class ISS extends Imposto{
	
	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ISS(){
		
	}
	
	@Override
	public double calcula(Orcamento o){
		return o.getValor() * 0.06 + calculoDoOutroImposto(o);
	}

}
