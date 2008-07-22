/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.maps.sample.maps.client;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.TrafficOverlay;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Google Maps API now allows you to add traffic information to your maps.
 * Traffic information is displayed using the GTrafficOverlay, which implements
 * the GOverlay interface. You add traffic information to your map using the
 * Map.addOverlay() method. GTrafficOverlay has two methods (hide() and
 * show()) for toggling display of the traffic overlay. Traffic information is
 * displayed only for supported cities.
 */
public class TrafficOverlayDemo extends MapsDemo {

  private MapWidget map;

  private TrafficOverlay trafficInfo;

  private boolean trafficShown;

  public static MapsDemoInfo init() {
    return new MapsDemoInfo() {
      public MapsDemo createInstance() {
        return new TrafficOverlayDemo();
      }

      public String getName() {
        return "Traffic Overlays";
      }
    };
  }

  public TrafficOverlayDemo() {
    Panel panel = new FlowPanel();

    map = new MapWidget(new LatLng(40.652513, -73.936615), 12);
    map.setSize("640px", "480px");
    panel.add(map);
    Button toggleTraffic = new Button("Toggle Traffic");
    toggleTraffic.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        if (trafficShown) {
          map.removeOverlay(trafficInfo);
        } else {
          map.addOverlay(trafficInfo);
        }
        trafficShown = !trafficShown;
      }
    });
    panel.add(toggleTraffic);
    initWidget(panel);
    trafficInfo = new TrafficOverlay();
  }

  public void onShow() {
    map.clearOverlays();
    map.addOverlay(trafficInfo);
    trafficShown = true;
  }
}