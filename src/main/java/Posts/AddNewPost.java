package Posts;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.LandingPage;

public class AddNewPost extends LandingPage{

	public AddNewPost(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//To click to add new post
	@FindBy(how=How.XPATH,using= "/html/body/div[1]/div[1]/div[2]/ul/li[3]/a/div[3]")
	private WebElement ChoosePost;
	@FindBy(how=How.CLASS_NAME,using ="page-title-action")
	private WebElement AddPost;
	//To post new info to new post
	@FindBy(how=How.NAME,using= "post_title")
	private WebElement AddPostName;
	@FindBy(how=How.XPATH,using= "//*[@id=\"content-html\"]")
	private WebElement ClickTOTextToPost;
	@FindBy(how=How.CLASS_NAME,using= "wp-editor-area")
	private WebElement AddTextToPost;
	
	
	
	//TO select media files to upload
	@FindBy(how=How.XPATH,using= "//*[@id=\"insert-media-button\"]")
	private WebElement AddMedia;
	@FindBy(how=How.LINK_TEXT,using= "Upload Files")
	private WebElement uploadMediaFile;
	@FindBy(how=How.ID,using= "__wp-uploader-id-1")
	private WebElement selectMedia;
	@FindBy(how=How.CSS,using= ".media-button")
	private WebElement InsertMediatoPost;
	@FindBy(how=How.XPATH,using= "//*[@id=\"save-post\"]")
	private WebElement savePost;






	
	private void clicktoAddPost()
	{
		ChoosePost.click();
		AddPost.click();
		
	}
	
	private void newPostInFo(String name,String Text)
	{
		AddPostName.sendKeys(name);
		ClickTOTextToPost.click();
		AddTextToPost.sendKeys(Text);
	}
	
	private void AddFile(String filepath) throws AWTException
	{
		AddMedia.click();
		uploadMediaFile.click();
		selectMedia.click();
		
		// copying file's absolute path to the clipboard
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//Pasting the file's absolute path into the File name field of the File Upload
		//native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();

		 //Press Control Key
        robot.keyPress(KeyEvent.VK_CONTROL);
        //Press 'V' key to paste file path
        robot.keyPress(KeyEvent.VK_V);
        //Release Control key
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Release 'V' key
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(1000);
        //Press Enter Key
        robot.keyPress(KeyEvent.VK_ENTER);
        //Release 'V' key
        robot.keyRelease(KeyEvent.VK_V);
     
  
       
		
	}
	
	public void savePost()
	{
		
	
		WebDriverWait d=new WebDriverWait(driver,30);
		 d.until(ExpectedConditions.elementToBeClickable(InsertMediatoPost));
		 InsertMediatoPost.click();
	
	
	}

	
	public AddNewPost FillPostinfo(String name,String Text,String filepath) throws AWTException
	{
		this.clicktoAddPost();
		this.newPostInFo(name, Text);
		this.AddFile(filepath);
		this.savePost();
		return new AddNewPost(driver);
	}
}


