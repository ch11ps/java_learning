package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletingTest extends TestBase {

  @Test
  public void testGroupDeleting() throws Exception {
    app.gotoGroupPage();
    app.selectGroup();
    app.delteSelectedGroup();
    app.returnToGroupPage();
  }

}