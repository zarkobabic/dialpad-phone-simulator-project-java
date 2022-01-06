package domaciZadatak3ZarkoBabic;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Tastatura extends Panel implements Runnable{
	public static final int BROJEVI = 0;
	public static final int SLOVA = 1;
	private Label natpis;
	private int rezim = BROJEVI;
	private Thread nit = null;
	private int aktivni = 0;
	private int stari = 0;
	private Button btn1 = new Button("1");
	private Button btn2 = new Button("2");
	private Button btn3 = new Button("3");
	private Button btn4 = new Button("4");
	private Button btn5 = new Button("5");
	private Button btn6 = new Button("6");
	private Button btn7 = new Button("7");
	private Button btn8 = new Button("8");
	private Button btn9 = new Button("9");
	private Button btn10 = new Button("*");
	private Button btn11 = new Button("0");
	private Button btn12 = new Button("+");
	
	
	
	
	

	public int getRezim() {
		return rezim;
	}

	
	
	public Thread getNit() {
		return nit;
	}
	
	
	
	public Tastatura(Label natpis) {
		this.natpis = natpis;
		Panel zanatpis = new Panel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		zanatpis.add(natpis);
		zanatpis.setPreferredSize(new Dimension(240,50));
		
		setPreferredSize(new Dimension(240,210));
		Font f = new Font("Lucida", Font.BOLD ,20);
		btn1.setFont(f);
		btn2.setFont(f);
		btn3.setFont(f);
		btn4.setFont(f);
		btn5.setFont(f);
		btn6.setFont(f);
		btn7.setFont(f);
		btn8.setFont(f);
		btn9.setFont(f);
		btn10.setFont(f);
		btn11.setFont(f);
		btn12.setFont(f);
		setLayout(new BorderLayout(0,0));
		Panel tast = new Panel(new GridLayout(4,3,0,0));
		tast.add(btn1);
		tast.add(btn2);
		tast.add(btn3);
		tast.add(btn4);
		tast.add(btn5);
		tast.add(btn6);
		tast.add(btn7);
		tast.add(btn8);
		tast.add(btn9);
		tast.add(btn10);
		tast.add(btn11);
		tast.add(btn12);
		add(zanatpis, BorderLayout.NORTH);
		add(tast, BorderLayout.CENTER);
		
		btn1.addActionListener(e->{
			synchronized(this) {aktivni = 1;
			notify();}
		});
		
		btn2.addActionListener(e->{
			synchronized(this) {aktivni = 2;
			notify();}
		});
		btn3.addActionListener(e->{
			synchronized(this) {aktivni = 3;
			notify();}
		});
		btn4.addActionListener(e->{
			synchronized(this) {aktivni = 4;
			notify();
			}
		});
		btn5.addActionListener(e->{
			synchronized(this) {aktivni = 5;
			notify();
			}
		});
		btn6.addActionListener(e->{
			synchronized(this) {aktivni = 6;
			notify();}
		});
		btn7.addActionListener(e->{
			synchronized(this) {aktivni = 7;
			notify();}
		});
		btn8.addActionListener(e->{
			synchronized(this) {aktivni = 8;
			notify();}
		});
		btn9.addActionListener(e->{
			synchronized(this) {aktivni = 9;
			notify();}
		});
		btn10.addActionListener(e->{
			synchronized(this) {aktivni = 10;
			notify();}
		});
		btn11.addActionListener(e->{
			synchronized(this) {aktivni = 11;
			notify();}
		});
		btn12.addActionListener(e->{
			synchronized(this) {aktivni = 12;
			notify();}
		});
		
		nit = new Thread(this);
		nit.start();
	}
	
	
	
	public synchronized void promeniNatpis(String s) {
		natpis.setText(s);
	}

	
	
	public synchronized void promeniRezimRada() {
		
		if(rezim == BROJEVI) { 
			rezim = SLOVA;
			btn1.setLabel("");
			btn2.setLabel("ABC");
			btn3.setLabel("DEF");
			btn4.setLabel("GHI");
			btn5.setLabel("JKL");
			btn6.setLabel("MNO");
			btn7.setLabel("PQRS");
			btn8.setLabel("TUV");
			btn9.setLabel("WXYZ");
			btn10.setLabel("");
			btn11.setLabel("_");
			btn12.setLabel("");
		}
		else {
			rezim = BROJEVI;
			btn1.setLabel("1");
			btn2.setLabel("2");
			btn3.setLabel("3");
			btn4.setLabel("4");
			btn5.setLabel("5");
			btn6.setLabel("6");
			btn7.setLabel("7");
			btn8.setLabel("8");
			btn9.setLabel("9");
			btn10.setLabel("*");
			btn11.setLabel("0");
			btn12.setLabel("+");
		}
	}

	
																												//RUN METODA
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				String pom = new String();
				
				synchronized(this) {
					while(!(aktivni < 13 && aktivni > 0)) {
						wait();
					}
					if(rezim == BROJEVI) {
							switch(aktivni) {
								case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:  {
									pom = natpis.getText();
									natpis.setText(pom + aktivni);
									break;
								}
								case 10: {
									pom = natpis.getText();
									natpis.setText(pom + "*");
									break;
								}
								case 11:{
									pom = natpis.getText();
									natpis.setText(pom + "0");
									break;
								}
								case 12:{
									pom = natpis.getText();
									natpis.setText(pom + "+");
									break;
								}
							}
							aktivni = 0;
							natpis.revalidate();
							
					}
					else {
						int cnt = -1;
						String pomstring = natpis.getText();
						stari = aktivni;
						  	do{
						  		cnt++;
						  		aktivni = 0;
						  		switch(stari){
							  		case 2: {
							  			cnt = cnt%3;
							  			switch(cnt){
							  				case 0: pom = "A"; break;
											case 1: pom = "B"; break;
											case 2: pom = "C"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 3: {
							  			cnt = cnt%3;
							  			switch(cnt){
								  			case 0: pom = "D"; break;
											case 1: pom = "E"; break;
											case 2: pom = "F"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 4: {
							  			cnt = cnt%3;
							  			switch(cnt){
								  			case 0: pom = "G"; break;
											case 1: pom = "H"; break;
											case 2: pom = "I"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 5: {
							  			cnt = cnt%3;
							  			switch(cnt){
								  			case 0: pom = "J"; break;
											case 1: pom = "K"; break;
											case 2: pom = "L"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 6: {
							  			cnt = cnt%3;
							  			switch(cnt){
								  			case 0: pom = "M"; break;
											case 1: pom = "N"; break;
											case 2: pom = "O"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 7: {
							  			cnt = cnt%4;
							  			switch(cnt){
								  			case 0: pom = "P"; break;
											case 1: pom = "Q"; break;
											case 2: pom = "R"; break;
											case 3: pom = "S"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 8: {
							  			cnt = cnt%3;
							  			switch(cnt){
								  			case 0: pom = "T"; break;
											case 1: pom = "U"; break;
											case 2: pom = "V"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 9: {
							  			cnt = cnt%4;
							  			switch(cnt){
								  			case 0: pom = "W"; break;
											case 1: pom = "X"; break;
											case 2: pom = "Y"; break;
											case 3: pom = "Z"; break;
							  			}
							  			break;
							  		}
							  		
							  		case 11:{
							  			pom = " ";
							  			stari = 13;
							  			break;
							  		}
							  		
							  	}
						  		natpis.setText(pomstring + pom);
						  		natpis.revalidate();
						  		wait(1000);
						  	} while (aktivni == stari);
					}
				}
			}
			synchronized (this) {
				nit = null;
				notify();
			}
		}catch(InterruptedException e) {}
	}
}
