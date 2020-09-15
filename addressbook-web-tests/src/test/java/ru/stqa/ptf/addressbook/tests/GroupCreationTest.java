package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}