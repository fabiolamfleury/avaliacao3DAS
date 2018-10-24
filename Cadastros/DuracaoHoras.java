package Cadastros;

public class DuracaoHoras {	
	Viagem viagem;
	int duracaoHoras;

	public DuracaoHoras(Viagem viagem) {
		this.viagem = viagem;
	}
	
	public int computar() {
		if (viagem.getHoraTermino() == viagem.getHoraInicio())
			duracaoHoras = 0;
		else if (viagem.getHoraTermino() > viagem.getHoraInicio()) { //varias possibilidades... 
			if (diferencaHoraTerminoInicio() == 1) {  
				if (isMinutoInicioGreaterthanMinutoTermino())  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (diferencaHoraTerminoInicio() > 2) //
					duracaoHoras = diferencaHoraTerminoInicio();
				else if (diferencaHoraTerminoInicio() == 2 &&   //certamente menos de duas horas  
						isMinutoInicioGreaterthanMinutoTermino())    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;		
			}
		}
		else
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}

	private boolean isMinutoInicioGreaterthanMinutoTermino() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	private int diferencaHoraTerminoInicio() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}
}
