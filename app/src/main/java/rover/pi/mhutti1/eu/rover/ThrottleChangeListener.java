package rover.pi.mhutti1.eu.rover;

import android.content.Context;
import android.widget.SeekBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Isaac on 21/02/2017.
 */

class ThrottleChangeListener implements SeekBar.OnSeekBarChangeListener{

  private final String url;

  public ThrottleChangeListener(String url) {
    this.url = url;
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    sendUpdate(seekBar);
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {

  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    seekBar.setProgress(50);
  }

  private void sendUpdate(SeekBar seekbar) {
    // Instantiate the RequestQueue.
    RequestQueue queue = Volley.newRequestQueue(seekbar.getContext());
    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url + (seekbar.getProgress() - 50),
        new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {}
        }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
    });
// Add the request to the RequestQueue.
    queue.add(stringRequest);
  }

}
