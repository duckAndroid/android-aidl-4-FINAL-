// ActPN.aidl
package com.pythoncat.appb.callback;
import com.pythoncat.appb.bean.PhoneNumber;
import com.pythoncat.appb.bean.PNResp;
// Declare any non-default types here with import statements

interface ActPN {

   void call(in PhoneNumber pn);
}
