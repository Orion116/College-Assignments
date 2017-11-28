class ExceptionHandling extends Exception
{
	JOptionPaneErrorPopUp errorPopUp = null;

	public ExceptionHandling( String message )
	{
		super();
		errorPopUp = new JOptionPaneErrorPopUp( message );
	}
}