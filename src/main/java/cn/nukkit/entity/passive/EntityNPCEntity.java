package cn.nukkit.entity.passive;

import cn.nukkit.Player;
import cn.nukkit.entity.EntityInteractable;
import cn.nukkit.entity.EntityLiving;
import cn.nukkit.entity.data.IntEntityData;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author good777LUCKY
 */
public class EntityNPCEntity extends EntityLiving implements EntityNPC, EntityInteractable {
    //TODO: return working NPC's if someone needs them XD
    
    public static final int NETWORK_ID = 51;

    public static final String KEY_DIALOG_TITLE = "DialogTitle";
    public static final String KEY_DIALOG_CONTENT = "DialogContent";
    public static final String KEY_DIALOG_SKINDATA = "DialogSkinData";
    public static final String KEY_DIALOG_BUTTONS = "DialogButtons";

    protected int variant = 0;
    
    public EntityNPCEntity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 2.1f;
    }

    @Override
    public boolean canDoInteraction() {
        return true;
    }

    @Override
    public String getInteractButtonText() {
        return "";
    }

    @Override
    public String getInteractButtonText(Player player) {
        return player.isCreative() ? "action.interact.edit" : "action.interact.talk";
    }

    @Override
    public String getOriginalName() {
        return "NPC";
    }

    @Override
    public void initEntity() {
        super.initEntity();
        this.setMaxHealth(Integer.MAX_VALUE); // Should be Float max value
        this.setHealth(20);
        this.setNameTagVisible(true);
        this.setNameTagAlwaysVisible(true);
        this.setVariant(this.namedTag.getInt("Variant"));
    }

    @Override
    public void saveNBT() {
        super.saveNBT();
        this.namedTag.putInt("Variant", this.variant);
    }

    @Override
    public boolean attack(EntityDamageEvent source) {
        if (source instanceof EntityDamageByEntityEvent event && event.getDamager() instanceof Player damager && damager.isCreative()) {
            this.kill();
        }
        return false;
    }

    public int getVariant() {
        return this.variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
        this.setDataProperty(new IntEntityData(DATA_VARIANT, variant));
    }
}
