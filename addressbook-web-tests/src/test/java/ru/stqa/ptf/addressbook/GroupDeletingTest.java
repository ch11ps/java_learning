package ru.stqa.ptf.addressbook;

import org.testng.annotations.*;

public class GroupDeletingTest extends TestBase {

  @Test
  public void testGroupDeleting() throws Exception {
    gotoGroupPage();
    selectGroup();
    delteSelectedGroup();
    returnToGroupPage();
  }

}