package riflesoundfix;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = RifleSoundFixMod.MODID,
        name = RifleSoundFixMod.NAME,
        version = RifleSoundFixMod.VERSION,
        clientSideOnly = true,
        acceptedMinecraftVersions = "[1.8.9]"
)
public class RifleSoundFixMod {

    public static final String MODID = "riflesoundfix";
    public static final String NAME = "Rifle Sound Fix";
    public static final String VERSION = "1.0.0";

    private static final ResourceLocation FIXED_LOCATION =
            new ResourceLocation("fireworks.largeBlast");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlaySound(PlaySoundEvent event) {
        ISound sound = event.sound;
        if (sound == null) {
            return;
        }

        ResourceLocation location = sound.getSoundLocation();
        if (location == null) {
            return;
        }

        if ("minecraft".equals(location.getResourceDomain())
                && FIXED_LOCATION.getResourcePath().equalsIgnoreCase(location.getResourcePath())
                && !FIXED_LOCATION.getResourcePath().equals(location.getResourcePath())) {

            event.result = new PositionedSoundRecord(
                    FIXED_LOCATION,
                    sound.getVolume(),
                    sound.getPitch(),
                    sound.getXPosF(),
                    sound.getYPosF(),
                    sound.getZPosF());
        }
    }
}
