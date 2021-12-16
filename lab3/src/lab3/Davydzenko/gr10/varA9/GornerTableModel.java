package lab3.Davydzenko.gr10.varA9;

import javax.swing.table.AbstractTableModel;  
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel { 
	private Double[] coefficients;
	private Double from; 
	private Double to; 
	private Double step;
	
	public GornerTableModel(Double from, 
			Double to, Double step, Double[] coefficients)
	{ this.from = from;
	this.to = to; 
	this.step = step; 
	this.coefficients = coefficients; } 
	
	public Double getFrom() 
	{ return from; } 
	
	public Double getTo() 
	{ return to; }
	
	public Double getStep()
	{ return step; } 
	public int getColumnCount() 
	{ return 4; } 
	
	public int getRowCount() 
	{return new Double(Math.ceil((to-from)/step)).intValue()+1; } 
	
	public Object getValueAt(int row, int col) { 
		Double x = from + step*row; 
		
		 Double result = x,t=x;
	       int i=0;

	 for (i=0;i<coefficients.length-1;i++)
		{result=(result+coefficients[i])*t;
	    }
		if (col==0) { return x; }
		if (col==1) {return result;}
		if(col == 2) 
		{
			String numberx,numbery,xx,yy;
			@SuppressWarnings("unused")
			int xxx,yyy;
				numberx=x.toString();
				numbery=result.toString();
				xx=numberx.substring(0,numberx.indexOf("."));
				yy=numberx.substring(0,numbery.indexOf("."));
			    xxx=Integer.parseInt(xx);
			    yyy=Integer.parseInt(yy);
				if(result>0) {
			return true;
				}
				else return false;
		}
		else{ String numberx,numbery,xx,yy;
		@SuppressWarnings("unused")
		int xxx,yyy;
			numberx=x.toString();
			numbery=result.toString();
			xx=numberx.substring(0,numberx.indexOf("."));
			yy=numberx.substring(0,numbery.indexOf("."));
		    xxx=Integer.parseInt(xx);
		    yyy=Integer.parseInt(yy);
			if(result>1)
			{return false;
			
		    }		
		else return true;
			
		}
	}

	public String getColumnName(int col) 
{ 
		switch (col) 
	{ 
	case 0: return "Значение X"; 
	case 1: return "Значение многочлена"; 
	default: return "Малое число?";
	case 2 :return"Число больше нуля?";
	} 

} 
 

	
	public Class<?> getColumnClass(int col) {
	if(col==0) return Double.class; 
	if(col==1) return Double.class;
	else return Boolean.class;
	} 
	

}



