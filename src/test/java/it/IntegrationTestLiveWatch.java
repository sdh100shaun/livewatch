package it;

public class IntegrationTestLiveWatch extends AbstractIntegrationTestCase
{
	public void testPagesOnActionPage()
	{
        gotoPage("livewatch.action");
        assertTextPresent("pages");
	}
}
