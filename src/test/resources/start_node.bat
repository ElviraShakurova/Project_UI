java -jar selenium-server-standalone-4.15.0.jar -role node -nodeConfig node.json

java -jar selenium-server-4.15.0.jar -Dwebdriver.chrome.driver=C:/WebDriver/bin/chromedriver.exe -Dwebdriver.gecko.driver=C:/WebDriver/bin/geckodriver-v0.33.0-win64/geckodriver.exe node --hub http://172.25.48.1:4444/grid/register

java -jar selenium-server-4.15.0.jar node --hub http://172.25.48.1:4444/grid/register