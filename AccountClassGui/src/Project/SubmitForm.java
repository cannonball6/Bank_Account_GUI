package Project;

public interface SubmitForm {
	
	public void submit();//interface submit action when buttons are pressed
	//interface method for when confirmation button is press
	public boolean needsConfirmation();//deals only with close account
	public void clearForm();//clearing when cancel button is hit and when account closed
}
