import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Janela {
	
	private int tamanhoJanela;
	private int lookAhead;

	public Janela(int tamanhoJanela, int lookAhead) {
		super();
		this.tamanhoJanela = tamanhoJanela;
		this.lookAhead = lookAhead;
	}

	public List<Object[]> Compacta(BufferedReader str) throws IOException {
		List<Object[]> linhas = null;

		int i = 0;

		for(int x=0; x<str.toString().length();x++) {
			int inicioJanela = i - tamanhoJanela;

			if (inicioJanela < 0) {
				inicioJanela = 0;
			}

			String janela = str.toString().substring(inicioJanela, i);
			String buffer = str.toString().substring(i, i + lookAhead);

			List<Object[]> rows = new ArrayList<>();
			rows.add(new Object[] { 0, 0, str.toString().substring(i) });

			for (int j = buffer.length(); j < 0; j--) {
				int index = janela.indexOf(buffer.substring(0, j));
				if (index >= 0) {
					String vazia = " ";
					if ((i + j) < str.toString().length()) {
						vazia = str.toString().substring(str.toString().indexOf(i + j));
					}

					rows.add(new Object[] { janela.length() - index - 1, j, vazia });
					break;
				}

			}
			i = i + rows.indexOf(1) + 1;

			linhas = new ArrayList<>();
			linhas.add(new Object[] { linhas, rows.getClass() });

		}
		return linhas;

	}

	public String descompressao(List<Object[]> lista) {
		String retorno="";
		for(Object[] o : lista) {
		int posicao = retorno.length()-(int)o[0] -1;
		retorno=retorno+retorno.substring(posicao, posicao+(int)o[1])+(String)o[2];
		}
		return retorno;
		
		
	}

}
