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
package main.java.com.example.emitters;

import main.java.com.YeAJG.api.IEmitter;
import main.java.com.YeAJG.fx.ps.Emitter;

/**
 *
 * @author Richard Coan
 */
public class ExampleEmitter extends Emitter implements IEmitter
{
    @Override
    public void Tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PostRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PreRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Generate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    public void generate(int num) {
        int i = 0;
        if(state == null) {
            logger.info("State not Initialized!");
            return;
        }
        Vector2f nsize;
        float modifier = 0.0f, rot = 0.0f;
        int n;
        
        while(i < num && list.size() < limit)
        {            
            if(state.parameters.containsKey("Distance.Min") || 
                    state.parameters.containsKey("Distance.Max"))
                modifier = Randomizer.getValue(
                        (float) state.parameters.get("Distance.Min"), 
                        (float) state.parameters.get("Distance.Max"));
            
            nsize = new Vector2f(state.size.x * modifier,
                    state.size.y * modifier);
            
            n = Randomizer.getValue(0, 255);
            rot = Randomizer.getValue(-2.0f, 2.f);
            logger.info(rot);
            
            Vector3f rotation = new Vector3f(state.rotation);
            rotation.z = rotation.z + rot;
            
            list.add(new Particle(
                new Vector3f(
                        Randomizer.getValue(location.x, size.x),
                        Randomizer.getValue(location.y, size.y), 
                        0f),
                new Vector2f(nsize),
                new Vector3f(state.scale),
                new Vector3f(state.velocity),
                new Vector3f(state.acceleration),
                rotation,
                new Vector3f(state.spin),               
                new HashMap(state.parameters),
                new Color(n,n,255,255),
                state.keepAlive
            ));
                        
            i++;
        }
    }*/
}