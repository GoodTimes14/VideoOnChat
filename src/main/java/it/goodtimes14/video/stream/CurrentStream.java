package it.goodtimes14.video.stream;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CurrentStream {


    private final File file;
    private final FrameGrab frameGrab;



    public CurrentStream(File file) {
        this.file = file;
        try {
            frameGrab = FrameGrab.createFrameGrab(NIOUtils.readableChannel(file));
        } catch (IOException | JCodecException e) {
            throw new IllegalStateException("Can't create frame grabber");
        }
    }


    public BufferedImage nextFrame() {
        try {
            Picture frame = frameGrab.getNativeFrame();
            if(frame == null) {
                return null;
            }
            return resize(AWTUtil.toBufferedImage(frame),35,20);
        } catch (IOException e) {
            return null;
        }
    }


    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }

}
