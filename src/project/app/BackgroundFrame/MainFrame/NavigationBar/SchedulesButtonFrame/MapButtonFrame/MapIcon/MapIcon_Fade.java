package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame.MapIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.ColorUtils.GREEN_WHITE;
import static project.app.Utilities.SizeUtils.*;

public class MapIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;
    public FillTransitionService ClickOnService, ClickOffService;

    public MapIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GREEN_GRAY(1), GREEN_WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(1), GREEN_GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M10 20C4.48372 20 0 15.5163 0 10C0 4.48372 4.48372 0 10 0C15.5163 0 20 4.48372 20 10C20 10.3814 19.6837 10.6977 19.3023 10.6977C18.9209 10.6977 18.6047 10.3814 18.6047 10C18.6047 9.27826 18.5153 8.57697 18.3471 7.90662C18.2811 7.90465 18.215 7.89455 18.149 7.86979C17.0135 7.49197 15.8529 7.19578 14.6779 6.9812C14.7899 7.98074 14.8465 8.98816 14.8465 10C14.8465 10.3814 14.5302 10.6977 14.1488 10.6977C13.7674 10.6977 13.4511 10.3814 13.4511 10C13.4511 8.9144 13.3826 7.83305 13.2468 6.76101C11.0956 6.49123 8.91183 6.49055 6.76051 6.75898C6.49114 8.91068 6.49099 11.095 6.76006 13.2467C7.8324 13.3826 8.91406 13.4512 10 13.4512C10.3814 13.4512 10.6977 13.7675 10.6977 14.1488C10.6977 14.5302 10.3814 14.8465 10 14.8465C8.98798 14.8465 7.98017 14.7904 6.97985 14.6785C7.19455 15.8564 7.49126 17.0199 7.87 18.1582C7.89155 18.2201 7.90374 18.2837 7.90702 18.3472C8.57725 18.5153 9.2784 18.6047 10 18.6047C10.3814 18.6047 10.6977 18.9209 10.6977 19.3023C10.6977 19.6837 10.3814 20 10 20ZM6.26068 17.6744C6.21862 17.6754 6.17758 17.6801 6.13784 17.6881C4.48938 16.8565 3.14307 15.5101 2.31162 13.8615C2.31978 13.8219 2.32454 13.7811 2.32558 13.7395C3.38075 14.0506 4.45093 14.2966 5.53186 14.477C5.70993 15.5553 5.95287 16.6235 6.26068 17.6744ZM1.65275 12.0928C1.48464 11.4226 1.39535 10.7215 1.39535 10C1.39535 9.27763 1.48485 8.57575 1.65335 7.90487C1.71627 7.90201 1.7797 7.89057 1.84202 7.86979C2.98345 7.48999 4.15032 7.19267 5.33159 6.97784C5.10982 8.9858 5.10992 11.0169 5.33188 13.0248C4.15521 12.8081 2.99269 12.5094 1.85117 12.1302C1.78614 12.1076 1.71939 12.0953 1.65275 12.0928ZM6.98074 5.32592C7.19536 4.14971 7.49178 2.98781 7.87 1.85115C7.89262 1.78611 7.90492 1.71935 7.90744 1.6527C8.57754 1.48462 9.27855 1.39535 10 1.39535C10.7222 1.39535 11.424 1.48482 12.0947 1.65325C12.0969 1.7192 12.1084 1.78579 12.1302 1.85118C12.509 2.99172 12.8075 4.15321 13.0242 5.32885C11.0182 5.1053 8.98807 5.10432 6.98074 5.32592ZM5.53148 5.52535C4.42131 5.7086 3.32172 5.96087 2.24083 6.28217C3.06562 4.56796 4.44213 3.16717 6.13855 2.31159C6.17822 2.31977 6.21904 2.32454 6.26068 2.32558C5.95264 3.37723 5.70957 4.44627 5.53148 5.52535ZM14.4755 5.53023C14.29 4.41947 14.0355 3.32072 13.7137 2.23883C15.4809 3.08798 16.9155 4.5234 17.7636 6.2913C16.684 5.9685 15.5853 5.71481 14.4755 5.53023Z M15.2539 18.5059C13.4581 18.5059 12 17.0483 12 15.253C12 13.4577 13.4581 12 15.2539 12C17.0498 12 18.5078 13.4577 18.5078 15.253C18.5078 15.9291 18.3011 16.5573 17.9473 17.0778C17.9645 17.0916 17.9811 17.1064 17.9971 17.1223L18.8208 17.9459C19.0597 18.1847 19.0597 18.58 18.8208 18.8188C18.6973 18.9424 18.5407 19 18.3842 19C18.2277 19 18.0712 18.9424 17.9476 18.8188L17.1238 17.9953C17.1079 17.9794 17.0931 17.9628 17.0793 17.9456C16.5586 18.2992 15.9302 18.5059 15.2539 18.5059ZM13.2357 15.253C13.2357 14.1412 14.1418 13.2353 15.2539 13.2353C16.366 13.2353 17.2722 14.1412 17.2722 15.253C17.2722 16.3647 16.366 17.2706 15.2539 17.2706C14.1418 17.2706 13.2357 16.3647 13.2357 15.253Z");
        setFill(GREEN_WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(10*UNIT-Bounds.getMinX()); setLayoutY(10*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}