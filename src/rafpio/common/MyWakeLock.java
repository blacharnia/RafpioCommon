package rafpio.common;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class MyWakeLock {
  private static WakeLock sCpuWakeLock;

  static void acquireCpuWakeLock(Context context) {
      if (sCpuWakeLock != null) {
          return;
      }

      PowerManager pm =
              (PowerManager) context.getSystemService(Context.POWER_SERVICE);

      sCpuWakeLock = pm.newWakeLock(
              PowerManager.FULL_WAKE_LOCK |
              PowerManager.ACQUIRE_CAUSES_WAKEUP |
              PowerManager.ON_AFTER_RELEASE, "rafpio.jobmate");
      
      sCpuWakeLock.acquire();
      
  }

  static void releaseCpuLock() {
      if (sCpuWakeLock != null) {
          sCpuWakeLock.release();
          sCpuWakeLock = null;
      }
  }
}
