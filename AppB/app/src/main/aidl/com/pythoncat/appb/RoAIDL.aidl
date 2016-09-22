// RoAIDL.aidl
package com.pythoncat.appb;
import com.pythoncat.appb.callback.Act;
// Declare any non-default types here with import statements

interface RoAIDL {

  int applyTribe();
  void applyTribeAsync(Act action);
}
