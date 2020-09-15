package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletingTest extends TestBase {

  @Test
  public void testGroupDeleting() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().delteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
