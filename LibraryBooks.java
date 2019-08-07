package Databaseprgms;

public class LibraryBooks {
	
	private int bno;
	private String bname,bauthor,bpublications,bgenre;
	private int bedition;
	private float bprice;
	
	 public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBpublications() {
		return bpublications;
	}

	public void setBpublications(String bpublications) {
		this.bpublications = bpublications;
	}

	public String getBgenre() {
		return bgenre;
	}

	public void setBgenre(String bgenre) {
		this.bgenre = bgenre;
	}

	public int getBedition() {
		return bedition;
	}

	public void setBedition(int bedition) {
		this.bedition = bedition;
	}

	public float getBprice() {
		return bprice;
	}

	public void setBprice(float bprice) {
		this.bprice = bprice;
	}


	public LibraryBooks() {
			super();
			// TODO Auto-generated constructor stub
		}
	 
	public LibraryBooks(int b,String bnam,String auth,String pubs,String gen,int edi,float pri)	
	{
		super(); 
		bno=b;
		bname=bnam; 
		bauthor=auth;
		bpublications=pubs;
		bgenre=gen;
		bedition=edi;
		bprice=pri;
				
	}
	}

