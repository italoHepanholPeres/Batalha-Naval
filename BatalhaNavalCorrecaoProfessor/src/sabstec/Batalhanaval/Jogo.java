package sabstec.Batalhanaval;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		// Variaveis
		boolean semResposta = true;
		int linha = 0;
		int coluna = 0;
		int linhaInicialSubmarino = 0;
		int linhaInicialDestroyer = 0;
		int linhaInicialCruzador = 0;
		int linhaInicialPortaAvioes = 0;

		int colunaInicialSubmarino = 0;
		int colunaInicialDestroyer = 0;
		int colunaInicialCruzador = 0;
		int colunaInicialPortaAvioes = 0;

		int colunaInicialVerificaVazio = 0;
		int colunaMinimaSubmarino = 0;
		int colunaMinimaDestroyer = 0;
		int colunaMinimaCruzador = 0;
		int colunaMinimaPortaavioes = 0;

		int linhaInicialVerificaVazio = 0;
		int linhaMinimaSubmarino = 0;
		int linhaMinimaDestroyer = 0;
		int linhaMinimaCruzador = 0;
		int linhaMinimaPortaAvioes = 0;

		int acertoSubmarino = 0;
		int acertoDestroyer = 0;
		int acertoCruzador = 0;
		int acertoPortaAviao = 0;
		String[] naviosDestruidos = new String[4];

		int colunaJogando;
		int linhaJogando;
		int jogadas = 0;
		int erros = 0;
		int errosParaReceberAjuda = 0;
		int jogadasParaReceberAjuda = 5;
		String querAjuda;
		int sorteioGenerico;

		String permaneceNoJogo = "";
		Scanner entrada = new Scanner(System.in);
		Random gerador = new Random();
		int sorteioSubmarino;
		int sorteioDestroyer;
		int sorteioCruzador;
		int sorteioPortaAvioes;

		boolean naoPodeIncluirNoTabuleiro = true;

		// Incio do jogo
		System.out.println("=========================================================================");
		System.out.println("                           BATALHA NAVAL");
		System.out.println();
		System.out.println("Criado por: Anderson.\n modificado e melhorado por Ítalo");
		System.out.println("=========================================================================");

		System.out.println();
		System.out.println("Carregando o jogo....");

		// Verifica se valores do tabuleiro estão ok
		while (linha < 11 || coluna < 11) {

			System.out.println("Digite a qtde de linhas do tabuleiro:");
			linha = entrada.nextInt();

			System.out.println("Digite a qtde de colunas do tabuleiro:");
			coluna = entrada.nextInt();

			if (linha < 11) {
				System.out.println("O numero de linhas não pode ser menor do que 11 !!!");
			}

			if (coluna < 11) {
				System.out.println("O numero de colunas não pode ser menor do que 11 !!!");
			}

		}

		// Criação do tabuleiro
		String[][] tabuleiro = new String[linha][coluna];
		String[][] nomeNavio = new String[linha][coluna];

		String submarino[] = { "S", "U", "B", "M", "A", "R", "I", "N", "O" };
		String destroyer[] = { "D", "E", "S", "T", "R", "O", "Y", "E", "R" };
		String portaAvioes[] = { "P", "O", "R", "T", "A", "A", "V", "I", "O", "E", "S" };
		String cruzador[] = { "C", "R", "U", "Z", "A", "D", "O", "R" };

		// sorteio do submarino
		sorteioSubmarino = gerador.nextInt(2);

		// Verifica se é linha
		if (sorteioSubmarino == 0) {
			// Distribuir os navios em linha
			naoPodeIncluirNoTabuleiro = true;

			// Submarino - Verifica se tem espaço vazio
			while (naoPodeIncluirNoTabuleiro) {
				linhaInicialSubmarino = gerador.nextInt(linha);
				// Tamanho do submarino
				colunaMinimaSubmarino = coluna - submarino.length;
				colunaInicialSubmarino = gerador.nextInt(colunaMinimaSubmarino);
				colunaInicialVerificaVazio = colunaInicialSubmarino;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < submarino.length; i++) {

					if (tabuleiro[linhaInicialSubmarino][colunaInicialVerificaVazio] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = submarino.length + 1;
					}

					colunaInicialVerificaVazio++;
				}

			}

			// Preencher o submarino no tabuleiro
			for (int i = 0; i < submarino.length; i++) {
				tabuleiro[linhaInicialSubmarino][colunaInicialSubmarino] = submarino[i];
				nomeNavio[linhaInicialSubmarino][colunaInicialSubmarino] = "submarino";
				colunaInicialSubmarino++;
			}
			// verifica se é coluna
		} else if (sorteioSubmarino == 1) {
			naoPodeIncluirNoTabuleiro = true;

			// Submarino - Verifica se tem espaço vazio
			while (naoPodeIncluirNoTabuleiro) {
				colunaInicialSubmarino = gerador.nextInt(coluna);
				// Tamanho do submarino
				linhaMinimaSubmarino = linha - submarino.length;
				linhaInicialSubmarino = gerador.nextInt(linhaMinimaSubmarino);
				linhaInicialVerificaVazio = linhaInicialSubmarino;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < submarino.length; i++) {

					if (tabuleiro[linhaInicialVerificaVazio][colunaInicialSubmarino] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = submarino.length + 1;
					}

					linhaInicialVerificaVazio++;
				}

			}

			// Preencher o submarino no tabuleiro
			for (int i = 0; i < submarino.length; i++) {
				tabuleiro[linhaInicialSubmarino][colunaInicialSubmarino] = submarino[i];
				nomeNavio[linhaInicialSubmarino][colunaInicialSubmarino] = "submarino";
				linhaInicialSubmarino++;
			}
		}

		// =================================================================

		// sorteio do destroyer
		sorteioDestroyer = gerador.nextInt(2);

		// verifica se é linha
		if (sorteioDestroyer == 0) {

			// Destroyer - Verifica se tem espaço vazio
			naoPodeIncluirNoTabuleiro = true;
			while (naoPodeIncluirNoTabuleiro) {
				linhaInicialDestroyer = gerador.nextInt(linha);
				// Tamanho do destroyer
				colunaMinimaDestroyer = coluna - destroyer.length;
				colunaInicialDestroyer = gerador.nextInt(colunaMinimaDestroyer);
				colunaInicialVerificaVazio = colunaInicialDestroyer;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < destroyer.length; i++) {

					if (tabuleiro[linhaInicialDestroyer][colunaInicialVerificaVazio] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = destroyer.length + 1;
					}

					colunaInicialVerificaVazio++;
				}

			}

			// Preencher o destroyer no tabuleiro
			for (int i = 0; i < destroyer.length; i++) {
				tabuleiro[linhaInicialDestroyer][colunaInicialDestroyer] = destroyer[i];
				nomeNavio[linhaInicialDestroyer][colunaInicialDestroyer] = "destroyer";
				colunaInicialDestroyer++;
			}
			// verifica se é coluna
		} else if (sorteioDestroyer == 1) {
			naoPodeIncluirNoTabuleiro = true;

			// destroyer - Verifica se tem espaço vazio
			while (naoPodeIncluirNoTabuleiro) {
				colunaInicialDestroyer = gerador.nextInt(coluna);
				// Tamanho do destroyer
				linhaMinimaDestroyer = linha - destroyer.length;
				linhaInicialDestroyer = gerador.nextInt(linhaMinimaDestroyer);
				linhaInicialVerificaVazio = linhaInicialDestroyer;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < destroyer.length; i++) {

					if (tabuleiro[linhaInicialVerificaVazio][colunaInicialDestroyer] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = destroyer.length + 1;
					}

					linhaInicialVerificaVazio++;
				}

			}

			// Preencher o destroyer no tabuleiro
			for (int i = 0; i < destroyer.length; i++) {
				tabuleiro[linhaInicialDestroyer][colunaInicialDestroyer] = destroyer[i];
				nomeNavio[linhaInicialDestroyer][colunaInicialDestroyer] = "destroyer";
				linhaInicialDestroyer++;
			}
		}

		// ==============================================================

		// sorteio do cruzador
		sorteioCruzador = gerador.nextInt(2);

		// verifica se é linha
		if (sorteioCruzador == 0) {
			naoPodeIncluirNoTabuleiro = true;
			while (naoPodeIncluirNoTabuleiro) {
				linhaInicialCruzador = gerador.nextInt(linha);
				// Tamanho do destroyer
				colunaMinimaCruzador = coluna - cruzador.length;
				colunaInicialCruzador = gerador.nextInt(colunaMinimaCruzador);
				colunaInicialVerificaVazio = colunaInicialCruzador;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < cruzador.length; i++) {

					if (tabuleiro[linhaInicialCruzador][colunaInicialVerificaVazio] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = cruzador.length + 1;
					}

					colunaInicialVerificaVazio++;
				}

			}
			// Preencher o cruzador no tabuleiro
			for (int i = 0; i < cruzador.length; i++) {
				tabuleiro[linhaInicialCruzador][colunaInicialCruzador] = cruzador[i];
				nomeNavio[linhaInicialCruzador][colunaInicialCruzador] = "cruzador";
				colunaInicialCruzador++;
			}
			// verifica se é coluna
		} else if (sorteioCruzador == 1) {
			naoPodeIncluirNoTabuleiro = true;
			while (naoPodeIncluirNoTabuleiro) {
				colunaInicialCruzador = gerador.nextInt(coluna);
				// Tamanho do cruzador
				linhaMinimaCruzador = linha - cruzador.length;
				linhaInicialCruzador = gerador.nextInt(linhaMinimaCruzador);
				linhaInicialVerificaVazio = linhaInicialCruzador;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < cruzador.length; i++) {

					if (tabuleiro[linhaInicialVerificaVazio][colunaInicialCruzador] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = cruzador.length + 1;
					}

					linhaInicialVerificaVazio++;
				}

			}

			// Preencher o cruzador no tabuleiro
			for (int i = 0; i < cruzador.length; i++) {
				tabuleiro[linhaInicialCruzador][colunaInicialCruzador] = cruzador[i];
				nomeNavio[linhaInicialCruzador][colunaInicialCruzador] = "cruzador";
				linhaInicialCruzador++;
			}
		}

		// ==========================================================

		// sorteio do portaavioes
		sorteioPortaAvioes = gerador.nextInt(2);

		// verifica se é linha
		if (sorteioPortaAvioes == 0) {
			naoPodeIncluirNoTabuleiro = true;
			while (naoPodeIncluirNoTabuleiro) {
				linhaInicialPortaAvioes = gerador.nextInt(linha);
				// tamanho do portaavioes
				colunaMinimaPortaavioes = coluna - portaAvioes.length;
				colunaInicialPortaAvioes = gerador.nextInt(colunaMinimaPortaavioes);
				colunaInicialVerificaVazio = colunaInicialPortaAvioes;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < portaAvioes.length; i++) {
					if (tabuleiro[linhaInicialPortaAvioes][colunaInicialVerificaVazio] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = portaAvioes.length + 1;
					}
					colunaInicialVerificaVazio++;
					;
				}
			}
			// preencher o portaavioes

			for (int i = 0; i < portaAvioes.length; i++) {
				tabuleiro[linhaInicialPortaAvioes][colunaInicialPortaAvioes] = portaAvioes[i];
				nomeNavio[linhaInicialPortaAvioes][colunaInicialPortaAvioes] = "portaAvião";
				colunaInicialPortaAvioes++;
			}
			// verifica se é coluna
		} else if (sorteioPortaAvioes == 1) {
			naoPodeIncluirNoTabuleiro = true;
			while (naoPodeIncluirNoTabuleiro) {
				colunaInicialPortaAvioes = gerador.nextInt(coluna);
				// Tamanho do portaavioes
				linhaMinimaPortaAvioes = linha - portaAvioes.length;
				linhaInicialPortaAvioes = gerador.nextInt(linhaMinimaPortaAvioes);
				linhaInicialVerificaVazio = linhaInicialPortaAvioes;

				naoPodeIncluirNoTabuleiro = false;
				for (int i = 0; i < portaAvioes.length; i++) {

					if (tabuleiro[linhaInicialVerificaVazio][colunaInicialPortaAvioes] != null) {
						naoPodeIncluirNoTabuleiro = true;
						i = portaAvioes.length + 1;
					}

					linhaInicialVerificaVazio++;
				}

			}

			// Preencher o submarino no tabuleiro
			for (int i = 0; i < portaAvioes.length; i++) {
				tabuleiro[linhaInicialPortaAvioes][colunaInicialPortaAvioes] = portaAvioes[i];
				nomeNavio[linhaInicialPortaAvioes][colunaInicialPortaAvioes] = "portaAvião";
				linhaInicialPortaAvioes++;

			}
		}

		// =========================================================

		boolean continuaJogando = true;

		System.out.println("===========================================");
		System.out.println("             pronto para jogar!!!");
		System.out.println("===========================================");

		while (continuaJogando) {

			System.out.println("carregando...");
			System.out.println("coordenadas: ");
			System.out.println("informe uma linha");
			linhaJogando = entrada.nextInt();

			System.out.println("informe uma coluna");
			colunaJogando = entrada.nextInt();
			// Verifica se escolheu uma posição dentro do tabuleiro
			if (linhaJogando > linha || colunaJogando > coluna) {
				System.out.println("ERRO!!!!! TENTE UM NÚMERO DENTRO DO TABULEIRO");
			} else {
				// Verifica se acertou
				if (tabuleiro[linhaJogando - 1][colunaJogando - 1] != null) {
					System.out.println("Você acertou um pedaço do meu " + nomeNavio[linhaJogando - 1][colunaJogando - 1]
							+ " voce acertou o " + tabuleiro[linhaJogando - 1][colunaJogando - 1] + "!!!!");
					if (nomeNavio[linhaJogando - 1][colunaJogando - 1] == "submarino") {
						acertoSubmarino++;
					} else if (nomeNavio[linhaJogando - 1][colunaJogando - 1] == "destroyer") {
						acertoDestroyer++;

					} else if (nomeNavio[linhaJogando - 1][colunaJogando - 1] == "cruzador") {
						acertoCruzador++;

					} else if (nomeNavio[linhaJogando - 1][colunaJogando - 1] == "portaAvião") {
						acertoPortaAviao++;

					}
					jogadas++;
					errosParaReceberAjuda = 0;
					jogadasParaReceberAjuda = 5;
				} else {
					System.out.println("ÁGUA");
					jogadas++;
					erros++;
					errosParaReceberAjuda++;
				}
			}

			// verifica quantos e quais navios destruiu
			if (acertoSubmarino == submarino.length) {
				naviosDestruidos[1] = "submarino";
			} else if (acertoDestroyer == destroyer.length) {
				naviosDestruidos[2] = "destroyer";
			} else if (acertoCruzador == cruzador.length) {
				naviosDestruidos[3] = "cruzador";
			} else if (acertoPortaAviao == portaAvioes.length) {
				naviosDestruidos[4] = "portaAvioes";
			}

			for (int i = 0; i < 4; i++) {
				int acertos = 4;
				if (naviosDestruidos[i] != null) {
					System.out.println("voce destruiu o meu " + naviosDestruidos[i]);
					acertos = acertos - 1;
					System.out.println("faltam " + acertos + " navios");
				}
			}
			System.out.println("você jogou um total de " + jogadas);

			if (errosParaReceberAjuda == jogadasParaReceberAjuda) {
				semResposta = true;
				while (semResposta) {
					System.out.println("você quer uma dica?(s/n)");
					querAjuda = entrada.next().toUpperCase();
					if ("S".equals(querAjuda)) {
						sorteioGenerico = gerador.nextInt(2);
						if (sorteioGenerico == 0) {
							sorteioGenerico = gerador.nextInt(4);
							if (sorteioGenerico == 0) {
								System.out.println("tente acertar na linha " + linhaInicialSubmarino);
							} else if (sorteioGenerico == 1) {
								System.out.println("tente acertar na linha " + linhaInicialDestroyer);
							} else if (sorteioGenerico == 2) {
								System.out.println("tente acertar na linha " + linhaInicialCruzador);
							} else if (sorteioGenerico == 3) {
								System.out.println("tente acertar na linha " + linhaInicialPortaAvioes);
							}
						} else if (sorteioGenerico == 1) {
							sorteioGenerico = gerador.nextInt(4);
							if (sorteioGenerico == 0) {
								System.out.println("tente acertar na coluna " + colunaInicialSubmarino);
							} else if (sorteioGenerico == 1) {
								System.out.println("tente acertar na coluna " + colunaInicialDestroyer);
							} else if (sorteioGenerico == 2) {
								System.out.println("tente acertar na coluna " + colunaInicialCruzador);
							} else if (sorteioGenerico == 3) {
								System.out.println("tente acertar na coluna " + colunaInicialPortaAvioes);
							}
						}
						errosParaReceberAjuda = 0;
						jogadasParaReceberAjuda++;
						semResposta = false;
					} else if ("N".equals(permaneceNoJogo)) {
						jogadasParaReceberAjuda = 5;
						errosParaReceberAjuda--;
						semResposta = false;
					} else {
						semResposta = true;
					}
				}
			}

			// Verifica se quer sair do jogo
			semResposta = true;
			while (semResposta) {
				System.out.println("Deseja continuar jogando ? (S/N)");
				permaneceNoJogo = entrada.next().toUpperCase();
				if ("S".equals(permaneceNoJogo)) {
					semResposta = false;
					continuaJogando = true;
				} else if ("N".equals(permaneceNoJogo)) {
					semResposta = false;
					continuaJogando = false;
				} else {
					semResposta = true;
				}
			}

		}

		System.out.println("FIM DE JOGO !!!");

	}
}