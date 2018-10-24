package Cadastros;

public class DuracaoMinutos {
	Viagem viagem;
	int duracaoMinutos;

	public DuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int computar() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio())
			duracaoMinutos = diferencaMinutosTerminoInicio();
		else {
			duracaoMinutos = 60 + diferencaMinutosTerminoInicio();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

	private int diferencaMinutosTerminoInicio() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}
}
