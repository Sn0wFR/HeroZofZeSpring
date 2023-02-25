package fr.herozofzespring.domain.enumerator;

import lombok.Getter;

@Getter
public enum Rarity {
    COMMON(0),RARE(10),LEGENDARY(20);
    private final int buffer;
    Rarity(int buffer) {
        this.buffer = buffer;
    }

}
