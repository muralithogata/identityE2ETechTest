# identityE2ETechTest

Please note: Need to add the chrome driver as follows to the code.

For Mac:

If you are running on Mac, download and place the latest chrome driver in the following path

/usr/local/bin

For windows

Create a folder called ‘drivers’ under resources and  Download and place the latest chrome driver 

//Add the path of the ChromeDriver in the ‘CheckCarDetailsTest’ as follows

System.setProperty("webdriver.chrome.driver", “path of the chrome driver/chromedriver.exe");
driver = new ChromeDriver();
driver.get("URL");
