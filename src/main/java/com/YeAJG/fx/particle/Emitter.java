/*
 * The MIT License
 *
 * Copyright 2015 Richard.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package main.java.com.YeAJG.fx.particle;

import java.util.ArrayList;
import java.util.List;
import main.java.com.YeAJG.game.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Richard Coan
 */
public class Emitter {
    private static final Logger logger = LogManager.getLogger( Game.class.getName() );
    private final IEmitUpdater updater;
    private final int num_per_tick;
    private long lastUpdate;
    
    public Emitter(IEmitUpdater updater, Particle p, Vector3f location, Vector3f size, int num_per_tick, int limit)
    {        
        this.updater = updater;
        this.updater.setState(p);
        this.updater.setLimit(limit);
        this.updater.setLocation(location);
        this.updater.setSize(size);
        this.num_per_tick = num_per_tick;       
    }
    
    public void generate(int num) {
        updater.generate(num);
    }
        
    public void update(long next_game_tick) {
        if( next_game_tick > lastUpdate ) 
        {
            lastUpdate = next_game_tick;
            
            List<Particle> list = updater.getList();
            List<Particle> toRemove = new ArrayList();
            
            list.stream().forEach((p) -> {
                if(p.isDead())
                    toRemove.add(p);
                else
                    updater.update(p);
            });
            
            list.removeAll(toRemove);
            generate(num_per_tick);
        }
    }

    public void afterDraw() {
        
    }

    public void beforeDraw() {
        
    }

    public void draw() {
        List<Particle> list = updater.getList();
        for(Particle p : list)
        {
            if(p.isVisible()) updater.draw(p);
        }
    }
    
}