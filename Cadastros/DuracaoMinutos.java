package Cadastros;

public class DuracaoMinutos {
	Viagem viagem;
	int duracaoMinutos;

	public DuracaoMinutos(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int computar() {
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio())
			duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
}
