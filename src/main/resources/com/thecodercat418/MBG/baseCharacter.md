# Base Character Rules

BaseCharacter is the basis of all characters in Magic Battle Game. The BaseCharacter manages health and defence.

## How does damage work?

Damage has a few properties, The first one is damage itself. The health string contains simple modifiers like ```+20``` will add 20 to health, whereas ```-20``` will remove 20 health.

Percents (```%```) work as well, and function as you think they would. If I have 100 health and pass ```%20``` to the health modifier, we will be left with with 80 health.

## Damage Placement

Some spells have damage that deals over time. That's when SpellEffect becomes very handy. We can use SpellEffect to have the BaseCharacter remember that it has damage to process every turn. It also allows for SpellEffect to play at diffrent times than just standard.
