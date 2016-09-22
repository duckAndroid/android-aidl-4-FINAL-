// RoAIDL.aidl
package com.pythoncat.appb;
import com.pythoncat.appb.callback.Act;
import com.pythoncat.appb.callback.ActPN;
import com.pythoncat.appb.bean.PhoneNumber;
import com.pythoncat.appb.bean.PNResp;
// Declare any non-default types here with import statements

interface RoAIDL {

  int applyTribe();
  void applyTribeAsync(Act action);
  void attribution(ActPN apn);
}
